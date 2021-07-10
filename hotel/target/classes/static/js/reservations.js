$(function () {
    //include header
    $("#includedContent").load("header.html");
    getAllReservations();
});

function getAllReservations() {
//    addRoomsFromTestData();
    $.ajax({
        url: 'http://localhost:8080/hotel/reservations',
        type: 'GET',
        contentType: 'application/json',
        dataType: "json"
    }).done(function (data) {
        $('#reservationsTable').dataTable({
            order: [[ 0, "asc" ]],
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


//                { data: "id", title: "Id" },
                { data: "room", title: "Room No",
                      render: function (data){
                              return data["id"];
                            }
                      },
                { data: "guest", title: "Guest",
                      render: function(data){
                            return data["firstName"] + " " + data["lastName"];                        }
                      },
                { data: "startDate", title: "From date" },
                { data: "endDate", title: "To Date" },
                { data: "checkIn", title: "Check In" },
                { data: "checkOut", title: "Check Out" },
                { data: "paymentDate", title: "Payment Date"},
                { data: "resChecked", title: "Checked"},
                { data: "price", title: "Total Price"},
                { data: "additionalPrice", title: "Additional Price"},
                { data: "paymentType", title: "payment Type"},
                { data: "resEnded", title: "Ended"},
                { data: "employee", title: "Employee",
                  render: function(data){
                            return data["firstName"] + " " + data["lastName"];                        }
                  },
                {
                    title: "Edit",
                    data: "id",
                    "searchable": false,
                    "sortable": false,
                    "render": function (data) {
                        var resIdEdit = "editReservation.html?id=" + data;
                        return '<a href="' + resIdEdit + '" class="editRes"><i class="fa fa-pencil fa-fw"></a>';
                    }
                },
                {
                    title: "Delete",
                    data: "id",
                    "searchable": false,
                    "sortable": false,
                    "render": function (data) {
                        var resIdEdit = "deleteReservation.html?id=" + data;
                        return '<a href="' + resIdEdit + '" class="deleteRes"><i class="fa fa-trash fa-fw"></a>';
                    }
                }
            ]
        });
    });
}