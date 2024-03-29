const editButton = document.getElementById("editEvent");
const deleteButton = document.getElementById("deleteEvent");
const closeEditButton = document.getElementById("closeEditEvent")
const modal2 = document.getElementById("modal2");

editButton.addEventListener("click", () => {
    const tutor = document.getElementById("editEventTutor").value;
    let split = tutor.split(' ');

    var editEventData = {
        id: document.getElementById("editEventId").value,
        title: document.getElementById("editEventTitle").value,
        tutorFirstName: split[0],
        tutorLastName: split[1],
        daysOfWeek: document.querySelector('input[name="editEventDayOfWeek"]:checked').value,
        weekType: document.querySelector('input[name="editEventWeekType"]:checked').value,
        field: document.getElementById("editEventField").value,
        description: document.getElementById("editEventDescription").value,
        startTime: document.getElementById("editEventStartTime").value,
        endTime: document.getElementById("editEventEndTime").value,
        color: document.getElementById("editEventColor").value,
        enabled: 1,
        createdBy: username
    }

    $.ajax({
        type: "POST",
        url: "/events",
        data: JSON.stringify(editEventData),
        dataType: "json",
        contentType: "application/json"
    });
    setTimeout(function() {
        window.location.reload()
    }, 100)
});

deleteButton.addEventListener("click", () => {
    $.ajax({
        type: "DELETE",
        url: "/events/" + document.getElementById("editEventId").value,
    });
    setTimeout(function() {
        window.location.reload()
    }, 100)
    
});

closeEditButton.addEventListener("click", () => {
    modal2.classList.remove("open");
});