const submitButton = document.getElementById("submitEvent");
const closeButton = document.getElementById("closeEvent")
const modal = document.getElementById("modal");

submitButton.addEventListener("click", () => {
    const tutor = document.getElementById("tutor").value;
    let split = tutor.split(' ');

    var addEventData = {
        title: document.getElementById("title").value,
        tutorFirstName: split[0],
        tutorLastName: split[1],
        daysOfWeek: document.querySelector('input[name="dayOfWeek"]:checked').value,
        weekType: document.querySelector('input[name="weekType"]:checked').value,
        field: document.getElementById("field").value,
        description: document.getElementById("description").value,
        startTime: document.getElementById("startTime").value,
        endTime: document.getElementById("endTime").value,
        color: document.getElementById("color").value,
        enabled: 1,
        createdBy: username
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
