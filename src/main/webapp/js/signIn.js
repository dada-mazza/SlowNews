function check(login, password) {
    var login = document.getElementById(login).value;
    var password = document.getElementById(password).value;
    var message = '';

    if ((login == null) || (login == '') || (login == undefined)) {
        message = 'Enter login';
    }
    if ((password == null) || (password == '') || (password == undefined)) {
        message = message + '\n' + 'Enter password';
    }
    if (message.length == 0) {
        return true;
    }
    alert(message);
    return false;
}
