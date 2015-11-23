function check(login, password, email, number) {
    var login = document.getElementById(login).value;
    var password = document.getElementById(password).value;
    var email = document.getElementById(email).value;
    var number = document.getElementById(number).value;
    var message = '';

    if ((login == null) || (login == '') || (login == undefined)) {
        message = 'Enter login';
    }
    if ((password == null) || (password == '') || (password == undefined)) {
        message = message + '\n' + 'Enter password';
    }
    if ((email == null) || (email == '') || (email == undefined)) {
        message = message + '\n' + 'Enter email';
    }
    if ((number == null) || (number == '') || (number == undefined)) {
        message = message + '\n' + 'Enter number';
    }
    if (message.length == 0) {
        return true;
    }
    alert(message);
    return false;
}