$(document).ready(function() {

    $('#roomTable').on('click', 'tbody tr td button', function (e) {
            e.preventDefault();
            var table = $('#roomTable').DataTable();
            let rowData = table.row($(this).parents('tr')).data();

            if ($(this).data('action') == "edit") {
                var selectedRoomType = rowData.type;
                $('#roomId').val(rowData.id);
                $('#roomId').prop("readonly", true);
//                $('#roomId').val(rowData.roomNo);
                $('input:radio[name="roomType"]').filter('[value="' + selectedRoomType + '"]').attr('checked', true).prop('checked', true);
                $('#roomSize').val(rowData.capacity);
                $('#roomPrice').val(rowData.price);
                $('#roomLastBigClean').val(rowData.lastBigCleaningDate);
                $('#roomBigCleanAfterInDays').val(rowData.numberOfDaysAfterBigClean);
                var selId = document.getElementById("roomUnderConstruction");
                selId.value = rowData.underConstruction ? "true" : "false";
                showFacilities(rowData.facilities);
            }
        });

    // click on button update
    $("#updateRoom").on('click', function(e) {
        e.preventDefault();
        var arrFacilities = getFacilities();
        var strType = $('input[name="roomType"]:checked').val();
        var underConst = $('#roomUnderConstruction option:selected').val();
        $.ajax({
            url: 'http://localhost:8080/hotel/room/edit',
            type: 'PUT',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({
                id: $("#roomId").val(),
                capacity: $('#roomSize').val(),
                price: $('#roomPrice').val(),
                type: strType,
                facilities: arrFacilities,
                underConstruction: underConst,
                lastBigCleaningDate: $('#roomLastBigClean').val(),
                numberOfDaysAfterBigClean: $('#roomBigCleanAfterInDays').val()
            }),
            success: function(result) {
                window.alert("The room was successfully updated.");
                setTimeout($('#edit_room_modal').modal('hide'), 2000);
                setTimeout("location.href = 'http://localhost:8080/rooms.html';", 3000);
            },
            error: function(e) {
                console.log(e);
            },
        });
    });

    // click on button submit
    $("#saveNewRoom").on('click', function() {
        var arrFacilities = getFacilities();
        var strType = $('input[name="roomType"]:checked').val();
        var underConst = $('#roomUnderConstruction option:selected').val();

        $.ajax({
            url: 'http://localhost:8080/hotel/room/add',
            type: 'POST',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({
                id: $("#roomId").val(),
                capacity: $('#roomSize').val(),
                price: $('#roomPrice').val(),
                type: strType,
                facilities: arrFacilities,
                underConstruction: underConst,
                lastBigCleaningDate: $('#roomLastBigClean').val(),
                numberOfDaysAfterBigClean: $('#roomBigCleanAfterInDays').val()
            }),
            success: function(result) {
                console.log(result);
                window.confirm("The new room is successfully added.");
                setTimeout("location.href = 'http://localhost:8080/rooms.html';", 3000);
            },
            error: function(e) {
                console.log(e);
            },
        });
    });
});