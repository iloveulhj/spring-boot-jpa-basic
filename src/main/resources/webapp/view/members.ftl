<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Members</title>
</head>

<body>
    <div id="app">
        <p v-model="welcomeMessage"></p>
    </div>
</body>

<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script>
var app = new Vue({
    el: '#app',
    data: {
        welcomeMessage: 'Member List',
        beforeLoadingMessage: 'before loading...',
        isLoading: false,

        members: []
    }
});

(function() {
    fetch('/v1/members')
      .then(response => { return response.json() })
      .then(data => {
        app.isLoading = true;
        app.members = data;
      });
}());
</script>
</html>