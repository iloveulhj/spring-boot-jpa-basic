<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Join</title>
</head>

<body>
<form>
    <div id="app">
        <div>
            <p>{{ pageTitle }}</p>
        </div>

        <div>
            Email: <input v-model="member.email" @blur="validateEmail"><br>
            <p v-if="message.name.email != 0" style="color: red;">{{ message.email }}</p><br>
            Password: <input v-model="member.password" @blur="validatePassword" type="password"><br>
            <p v-if="message.name.length != 0" style="color: red;">{{ message.password }}</p><br>
            <input type="button" @click="submit" value="submit">
        </div>
    </div>
</form>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            pageTitle: 'login',
            member: {
                email: '',
                password: ''
            },
            message: {
                email: '',
                password: ''
            },
        },
        methods: {
            validateEmail: function () {
                if (!app.member.email.includes('@')) {
                    app.message.email = '이메일을 확인해주세요.';
                } else {
                    app.message.email = '';
                }
            },
            validatePassword: function () {
                if (app.members.password.length == 0) {
                    app.message.password = '비밀번호를 확인해주세요';
                } else {
                    app.message.password = '';
                }
            },
            submit: function () {
                if (!app.member.email.includes('@')) {
                    alert('이메일을 확인해주세요.');
                    return;
                }

                if (app.members.password.length == 0) {
                    app.message.password = '비밀번호를 확인해주세요';
                }

                var formData = new FormData();
                formData.append('email', app.member.email);
                formData.append('password', app.member.password);

                fetch('/v1/members/', {
                    method: 'POST',
                    body: formData
                })
                .then(response => response.text())
                .then(response => {
                    if (response === 'register') {
                        alert('성공');
                    } else {
                        alert('실패');
                    }
                })
            }
        }
    });
</script>
</html>