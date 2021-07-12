    $(function () {
      $("#includedContent").load("header.html");
    });

function getFacilities() {
  var form = document.getElementById('input-facilities');

  var myArray = [];
  form.querySelectorAll('input').forEach(function (input) {
    if (input.type === 'checkbox' && input.checked) {
      myArray.push(input.value);
    }
  })
  document.getElementById('roomFacilities').value = myArray.toString();
}

function showFacilities(facilities) {
  var form = document.getElementById('input-facilities');
  var myArray = [];
  myArray = facilities.toString().split(',');
  form.querySelectorAll('input').forEach(function (input) {
    if (input.type === 'checkbox') {
      for (let i = 0, len = myArray.length; i < len; i++) {
//        console.log(myArray[i]);
        if (input.value.toUpperCase() == myArray[i].trim().toUpperCase()) {
          input.checked = true;
        }
      }
    }
  })
}