$(function () {

    $(document).ready(function () {
        var url = new URL(window.location.href);
        var id = url.searchParams.get("id");
        if (id !== null) getRoomById(id);
    });

    function getRoomById(id) {
        $.ajax({
            url: 'http://localhost:8080/api/room/' + id,
            type: 'GET',
        }).done(function (data) {
//            console.log(data.roomType);
            $('#roomId').val(data.roomId);
            var selectedRoomType = data.roomType.toLowerCase();
            $('input:radio[name="roomType"]').filter('[value="'+ selectedRoomType +'"]').attr('checked', true);
//            $('#roomType').val(data.roomType);
            $('#roomSize').val(data.roomSize);
            $('#roomPrice').val(data.roomPrice);
            $('#roomLastBigClean').val(data.roomLastBigClean);
            $('#roomBigCleanAfterInDays').val(data.roomBigCleanAfterInDays);
            var selId = document.getElementById("roomUnderConstruction");
            selId.value = data.roomUnderConstruction?"yes":"no";
//            $('#roomUnderConstruction').value = data.roomUnderConstruction?1:2;

            showFacilities(data.roomFacilities.toString());
        });
    }

    // click on button submit
    $("#submit").on('click', function () {
        getFacilities();
        $.ajax({
            url: 'http://localhost:8080/api/room/add',
            type: 'PUT',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({

                "roomId": document.getElementById('roomId').value,
                "roomType": document.getElementById('roomType').value,
                "roomSize": document.getElementById('roomSize').value,
                "roomPrice": document.getElementById('roomPrice').value,
                "roomFacilities": document.getElementById('roomFacilities').value
            }),
            success: function (result) {
                $("#messageLabel").html("Your data was successfully saved.");
                setTimeout("$('#messageLabel').html('');", 2000);
                setTimeout("location.href = 'http://localhost:8080/rooms.html';", 2000);
            },
            error: function (e) {
                console.log(e);
            },
        });
    });
});
