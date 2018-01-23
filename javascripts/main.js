function buildHtmlTable(selector) {
  var columns = Object.keys(eventTypes[0]);
  var toLowerCase = checkVersion();
  
  var headerTr$ = $('<tr/>');
  headerTr$.append($('<th/>').html("S.No"));
  headerTr$.append($('<th/>').html("Family"));
  headerTr$.append($('<th/>').html("Type"));
  headerTr$.append($('<th/>').html("Template of the Event"));
  headerTr$.append($('<th/>').html("Event Abbreviation"));
  headerTr$.append($('<th/>').html("Comments"));
  $(selector).append(headerTr$);
  
  for (var i = 0; i < eventTypes.length; i++) {
    var row$ = $('<tr/>');
    for (var colIndex = 0; colIndex < columns.length; colIndex++) {
      var cellValue = eventTypes[i][columns[colIndex]];
      if (cellValue == null) cellValue = "";
      if (colIndex == 3) {
    	  if(Boolean(toLowerCase)) cellValue = cellValue.toLowerCase();
    	  cellValue = '<a href="#" onClick="downloadTemplate(\''+cellValue+'\'); return false;">'+cellValue+'</a>';
      } 
      row$.append($('<td/>').html(cellValue));
    }
    $(selector).append(row$);
  }
}

function checkVersion() {
  var toLowerCase = false;
  var version = document.getElementById('version').value;
  var array = version.split('.');
  //Check if version is equal or higher than 0.3.5
  if(parseInt(array[0]) > 0 || parseInt(array[1]) > 3 || (parseInt(array[1]) == 3 && parseInt(array[2]) >= 5)) {
    toLowerCase = true;
  }
  return toLowerCase;
}

$(document).on('change','#version',function(){
  $('#eventTypesTable').empty();
  buildHtmlTable('#eventTypesTable');
});