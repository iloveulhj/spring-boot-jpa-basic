<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Members</title>
</head>

<body>
<div id="app">
    <div>
        <p>{{ pageTitle }}</p>
        <input v-model="pageTitle"/>
    </div>

    <div v-if="!isLoading">{{ beforeLoadingMessage }}</div>

    <div v-else>
        <ul>
            <li v-for="member in members">
                {{ member.id }} / {{ member.name }} / {{ member.email }}
            </li>
        </ul>
    </div>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            pageTitle: 'two-way binding',
            beforeLoadingMessage: 'before loading...',
            isLoading: false,
            members: []
        }
    });

    (function () {
        fetch('/v1/members')
            .then(response => {return response.json()})
            .then(data => {
                app.isLoading = true;
                app.members = data;
            });
    }());
</script>
</html>