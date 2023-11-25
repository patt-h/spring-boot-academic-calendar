const editButton = document.getElementById("editConsultation");
const deleteButton = document.getElementById("deleteConsultation");
const closeEditButton = document.getElementById("closeEditConsultation")
const modal2 = document.getElementById("modal2");

editButton.addEventListener("click", () => {
    var editConsultationData = {
        id: document.getElementById("editEventId").value,
        title: document.getElementById("editEventTitle").value,
        daysOfWeek: document.querySelector('input[name="editEventDayOfWeek"]:checked').value,
        weekType: "EW",
        field: document.getElementById("editEventField").value,
        description: document.getElementById("editEventDescription").value,
        startTime: document.getElementById("editEventStartTime").value,
        endTime: document.getElementById("editEventEndTime").value,
        color: "#D3D3D3",
        enabled: 1,
        createdBy: user
    }

    $.ajax({
        type: "POST",
        url: "/events",
        data: JSON.stringify(editConsultationData),
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