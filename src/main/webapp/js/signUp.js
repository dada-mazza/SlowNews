function check() {
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    var email = document.getElementById("email").value;
    var message = '';

    if ((login == null) || (login == '') || (login == undefined)) {
        message = 'Enter login';
    }
    if ((password == null) || (password == '') || (password == undefined)) {
        message = message + '\n' + 'Enter password';
    }
    if ((passwordConfirm == null) || (passwordConfirm == '') || (passwordConfirm == undefined)) {
        message = message + '\n' + 'Enter confirm password';
    }
    if ((email == null) || (email == '') || (email == undefined)) {
        message = message + '\n' + 'Enter email';
    }
    if (message.length == 0) {
        return true;
    }
    alert(message);
    return false;
}