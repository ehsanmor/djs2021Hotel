$(document).ready(function () {
    var url = new URL(window.location.href);
    var id = url.searchParams.get("id");
    if (id !== null) getGuestById(id);
});

function getGuestById(id) {
    $.ajax({
        url: 'http://localhost:8080/hotel/guest/' + id,
        type: 'GET',
    }).done(function (data) {

        $('#guestId').val(data.id);
        $('#firstName').val(data.firstName);
        $('#lastName').val(data.lastName);
        var selectedGuestType = data.type.toLowerCase();
        $('input:radio[name="type"]').filter('[value="'+ selectedGuestType +'"]').attr('checked', true);
        $('#email').val(data.email);
        $('#password').val(data.password);
        $('#telephoneNumber').val(data.telephoneNumber);
        $('#numberOfReservation').val(data.numberOfReservation);

    });
}