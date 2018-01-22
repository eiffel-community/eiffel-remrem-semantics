var currentlyLower = false;

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
    	  cellValue = '<a href="#" onClick="downloadTemplate("'+cellValue+'"); return false;">'+cellValue+'</a>';
      } 
      row$.append($('<td/>').html(cellValue));
    }
    $(selector).append(row$);
  }
}

$("#version").change(function () {
  $('#eventTypesTable').empty();
  buildHtmlTable('#eventTypesTable');
  }    
});