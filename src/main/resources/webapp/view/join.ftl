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
            Name: <input v-model="member.name" @blur="validateName($event)"><br>
            <p v-if="message.name.length != 0" style="color: red;">{{ message.name }}</p><br>
            Email: <input v-model="member.email"  @blur="validateEmail"><br>
            <p v-if="message.name.email != 0" style="color: red;">{{ message.email }}</p><br>
            <input type="button" @click="submit" value="submit">
        </div>
    </div>
</form>
</body>

<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            pageTitle: 'join',
            member:{
                name: '',
                email: ''
            },
            message: {
                name: '',
                email: ''
            },
        },
        methods: {
            validateName: function(event) {
                if(event.target.value.length == 0) {
                    app.message.name = '이름을 확인해주세요.';
                } else {
                    app.message.name = '';
                }
            },
            validateEmail: function() {
                if(!app.member.email.includes('@')) {
                    app.message.email = '이메일을 확인해주세요.';
                } else {
                    app.message.email = '';
                }
            },
            submit: function() {
                if(event.target.value.length == 0) {
                    alert('이름을 확인해주세요.');
                    return;
                }

                if(!app.member.email.includes('@')) {
                    alert('이메일을 확인해주세요.');
                    return;
                }

                var formData = new FormData();
                formData.append('name', app.member.name);
                formData.append('email', app.member.email);

                fetch('/v1/members/', {
                    method: 'POST',
                    body: formData
                }).then(response => response.text())
                  .then(response => {
                        if(response === 'register') {
                            alert('성공');
                        }else {
                            alert('실패');
                        }
                })
            }
        }
    });
</script>
</html>