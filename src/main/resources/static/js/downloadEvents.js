const exportButton = document.getElementById("exportButton");

exportButton.addEventListener("click", () => {
    $.ajax({
        type: "GET",
        url: "/download/" + document.getElementById("sorting").value
    }).done(function(result) {
        download("calendar-" + document.getElementById("sorting").value + ".ics", result);
    });
});


function download(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
  
    element.style.display = 'none';
    document.body.appendChild(element);
  
    element.click();
  
    document.body.removeChild(element);
  }

