const submitConsultation = document.getElementById("submitConsultation");
const closeButton = document.getElementById("closeEvent")
const modal = document.getElementById("modal");

submitConsultation.addEventListener("click", () => {
    var addConsultationData = {
        title: document.getElementById("title").value,
        daysOfWeek: document.querySelector('input[name="dayOfWeek"]:checked').value,
        weekType: "EW",
        field: document.getElementById("field").value,
        description: document.getElementById("description").value,
        startTime: document.getElementById("startTime").value,
        endTime: document.getElementById("endTime").value,
        color: "#D3D3D3"
    }

    $.ajax({
        type: "POST",
        url: "/events",
        data: JSON.stringify(addConsultationData),
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