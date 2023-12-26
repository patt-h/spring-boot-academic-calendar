const submitButton = document.getElementById("submitEvent");
const closeButton = document.getElementById("closeEvent")
const modal = document.getElementById("modal");

submitButton.addEventListener("click", () => {
    var addEventData = {
        title: document.getElementById("title").value,
        tutor: document.getElementById("tutor").value,
        daysOfWeek: document.querySelector('input[name="dayOfWeek"]:checked').value,
        weekType: document.querySelector('input[name="weekType"]:checked').value,
        field: document.getElementById("field").value,
        description: document.getElementById("description").value,
        startTime: document.getElementById("startTime").value,
        endTime: document.getElementById("endTime").value,
        color: document.getElementById("color").value,
        enabled: 1,
        createdBy: user
    }

    $.ajax({
        type: "POST",
        url: "/events",
        data: JSON.stringify(addEventData),
        dataType: "json",
        contentType: "application/json"
    });
    setTimeout(function() {
        window.location.reload()
    }, 100)
});

closeButton.addEventListener("click", () => {
    modal.classList.remove("open");
});
