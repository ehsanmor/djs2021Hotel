$(document).ready(function () {
    var url = new URL(window.location.href);
    var id = url.searchParams.get("id");
    if (id !== null) getRoomById(id);

    // click on button submit
    $("#updateRoom").on('click', function () {
        getFacilities();
        console.log("UPDATE");
        $.ajax({
            url: 'http://localhost:8080/hotel/room/edit/' + id,
            type: 'PUT',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({

                "type":$('input[name="type"]:checked').val(),
                "capacity":$('#roomSize').val(),
                "price":$('#roomPrice').val(),
                "facilities":$('#roomFacilities').val(),
    //            "underConstruction":$('#roomUnderConstruction').val(),
                "lastBigCleaningDate": toString($('#roomLastBigClean').val()),
                "numberOfDaysAfterBigClean":$('#numberOfDaysAfterBigClean').val()
            }),
            success: function (result) {
            console.log(result);
                $("#messageLabel").html("The room was successfully updated.");
                setTimeout("$('#messageLabel').html('');", 3000);
                setTimeout("location.href = 'http://localhost:8080/rooms.html';", 5000);
            },
            error: function (e) {
                console.log(e);
            },
        });
    });

    // click on button submit
        $("#submit").on('click', function () {
            getFacilities();

            $.ajax({
                url: 'http://localhost:8080/hotel/room',
                type: 'PUT',
                contentType: 'application/json',
                dataType: "json",
                data: JSON.stringify({
                    "id":$('#roomId').val(),
                    "type":$('input[name="type"]:checked').val(),
                    "capacity":$('#roomSize').val(),
                    "price":$('#roomPrice').val(),
                    "facilities":$('#roomFacilities').val(),
        //            "underConstruction":$('#roomUnderConstruction').val(),
                    "lastBigCleaningDate": toString($('#roomLastBigClean').val()),
                    "numberOfDaysAfterBigClean":$('#numberOfDaysAfterBigClean').val()
                }),
                success: function (result) {
                console.log(result);
                    $("#messageLabel").html("The room was successfully added.");
                    setTimeout("$('#messageLabel').html('');", 3000);
                    setTimeout("location.href = 'http://localhost:8080/rooms.html';", 5000);
                },
                error: function (e) {
                    console.log(e);
                },
            });
        });


});

function getRoomById(id) {
    $.ajax({
        url: 'http://localhost:8080/hotel/room/' + id,
        type: 'GET',
    }).done(function (data) {
//            console.log(data.roomType);
        $('#roomId').val(data.id);
        var selectedRoomType = data.type.toLowerCase();
        $('input:radio[name="roomType"]').filter('[value="'+ selectedRoomType +'"]').attr('checked', true);
//            $('#roomType').val(data.roomType);
        $('#roomSize').val(data.capacity);
        $('#roomPrice').val(data.price);
        $('#roomLastBigClean').val(data.lastBigCleaningDate);
        $('#roomBigCleanAfterInDays').val(data.numberOfDaysAfterBigClean);
        var selId = document.getElementById("roomUnderConstruction");
        selId.value = data.underConstruction?"yes":"no";
//            $('#roomUnderConstruction').value = data.roomUnderConstruction?1:2;

        showFacilities(data.facilities.toString());
    });
}
