$(function () {
    //include header
    $("#includedContent").load("header.html");
});

function roomNeedsCleaningCheck(lastCleanD, noDays){
    var from = lastCleanD.split("-");
    var lastCleanDate = new Date(from[2], from[1] - 1, from[0]);
    var diff = new Date(Date()) - lastCleanDate;
    var differenceDays = diff/1000/60/60/24;
    if (differenceDays >= noDays) {
        return true;
    }
    return false;
}

function StringToDate(dateStr) {
  var parts = dateStr.split("-")
  return new Date(parts[2], parts[1] - 1, parts[0])
}

function checkConstruction(statRoom){
    var result = statRoom == null || !statRoom?false:true;
    return result;
}

function addRoomsFromTestData(){
//this will post the test date to java first
    $.each(testData, function( index, value ) {
            postData = JSON.stringify({
                "roomId": value["roomId"],
                "roomType": value["roomType"],
                "roomSize": value["roomSize"],
                "roomPrice": value["roomPrice"],
                "roomFacilities": value['roomFacilities'],
                "roomLastBigClean": StringToDate(value['roomLastBigClean']),
                "roomBigCleanAfterInDays": parseInt(value['roomBigCleanAfterInDays']),
                "roomUnderConstruction": checkConstruction(value['roomUnderConstruction']),
                "roomNeedsCleaning": roomNeedsCleaningCheck(value["roomLastBigClean"], value["roomBigCleanAfterInDays"])
            });

            $.ajax({
                url: 'http://localhost:8080/hotel/room/add',
                type: 'PUT',
                contentType: 'application/json',
                dataType: "json",
                data: postData,
               success: function (result) {
//                  console.log("done");
               },
               error: function (e) {
                   console.log(e);
               },
            });
       });
 }


$(function getAllRooms() {
//    addRoomsFromTestData();
    $.ajax({
        url: 'http://localhost:8080/hotel/rooms',
        type: 'GET',
        contentType: 'application/json',
        dataType: "json"
    }).done(function (data) {
        $('#roomTable').dataTable({
            order: [[ 1, "asc" ]],
            data: data,
            columns: [
//                {
//                    data: "roomNeedsCleaning", title: "Needs Cleaning",
//                    render: function (data) {
//                        if (data) {
//                            return '<i class="fa fa-flag red-color"></i>';
//                        } else {
//                            return null;
//                        }
//                    }
//                },
                { data: "id", title: "Room Id" },
                { data: "type", title: "Room Type" },
                { data: "capacity", title: "Max Capacity" },
                { data: "price", title: "Price" },
                { data: "facilities", title: "Facilities"},
                { data: "lastBigCleaningDate", title: "Last Big Clean On:",
                  render: function (data){
                          var parts = data.split("-");
                          var formattedDate = parts[2] + "-" + parts[1] + "-" + parts[0];
                          return formattedDate;
                        }
                  },
                { data: "numberOfDaysAfterBigClean", title: "Big Clean After (in days)" },
                { data: "underConstruction", title: "Under Construction",
                  render: function(data){
                            return data?"Yes":"";
                        }
                  },
                {
                    title: "Edit",
                    data: "id",
                    "searchable": false,
                    "sortable": false,
                    "render": function (data) {
//                        console.log(data);
                        var roomIdEdit = "editroom.html?id=" + data;
                        return '<a href="' + roomIdEdit + '" class="editRoom"><i class="fa fa-pencil fa-fw"></a>';
                    }
                },
                {
                    title: "Delete",
                    data: "id",
                    "searchable": false,
                    "sortable": false,
                    "render": function (data) {
                        var roomIdEdit = "deleteroom.html?id=" + data;
                        return '<a href="' + roomIdEdit + '" class="deleteRoom"><i class="fa fa-trash fa-fw"></a>';
                    }
                }
            ]
        });
    });
});
