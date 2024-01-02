const closeButton = document.getElementById("closeEvent");
const closeTutor = document.getElementById("closeTutorDisplay")
const modal = document.getElementById("modal");
const modal2 = document.getElementById("modal2");
const container = document.getElementById("container");
const person = document.getElementById("dialog-person");

var classType;
var day;
var week;

var eventFirstName;
var eventLastName;

closeButton.addEventListener("click", () => {
    modal.classList.remove("open");
});

closeTutor.addEventListener("click", () => {
    modal2.classList.remove("open");
});

person.addEventListener("click", () => {
    modal.classList.remove("open");
    modal2.classList.add("open");

    document.getElementById("sortTutorHeader").innerHTML = "Inne zajęcia prowadzone przez "  + document.getElementById("dialog-person").innerHTML;
    
    $.ajax({
        type: "GET",
        url: "/events/" + eventFirstName + "+" + eventLastName,
        dataType: "json",
    }).done(function(result) {
        dataStore = "";
        let fullHTML = "";
        for (let i = 0; i < result.length; i++) {
            convertDayNumber(result[i].daysOfWeek);
            convertWeekType(result[i].weekType);
            convertColorCode(result[i].color);
            dataStore += `<p>
            <div style="display:grid;grid-template-columns:min-content 1fr;gap:.5rem;align-items:center;outline: black solid 1px;margin: 8px">
              <div class="material-symbols-outlined" aria-label="informacje">info</div>
              <slot id="tutor-dialog-info">${result[i].title + " - " + classType}</slot>
      
              <div class="material-symbols-outlined" aria-label="termin">calendar_month</div>
              <slot id="tutor-dialog-event">${day + " - " + week + " " + result[i].startTime + " - " + result[i].endTime}</slot>
      
              <div class="material-symbols-outlined" aria-label="miejsce">location_on</div>
              <slot id="tutor-dialog-place">${result[i].description}</slot>
            </div>
          </p>`
        }
        container.innerHTML = dataStore;
    });
})

function getTutorDetails(firstName, lastName) {
    eventFirstName = firstName;
    eventLastName = lastName;
}

function convertColorCode(color) {
    if (color == "GREEN") {
        classType = "Wykład"
    }
    else if (color == "#4682B4") {
        classType = "Laboratoria"
    }
    else if (color == "ORANGE") {
        classType = "Ćwiczenia"
    }
    else if (color == "#F8E473") {
        classType = "Projekt"
    }
    else if (color == "#7F00FF") {
        classType = "Seminarium"
    }
    else if (color == "#D3D3D3") {
        classType = "Konsultacje"
    }
};

function convertDayNumber(dayNumber) {
    if (dayNumber == 1) {
        day = "Poniedziałek"
    }
    else if (dayNumber == 2) {
        day = "Wtorek"
    }
    else if (dayNumber == 3) {
        day = "Środa"
    }
    else if (dayNumber == 4) {
        day = "Czwartek"
    }
    else if (dayNumber == 5) {
        day = "Piątek"
    }
}

function convertWeekType(weekType) {
    if (weekType == "TP") {
        week = "co drugi tydzień (parzysty)"
    }
    else if (weekType == "TN") {
        week = "co drugi tydzień (nieparzysty)"
    }
    else if (weekType == "EW") {
        if (day == "Środa") {
            week = "każda"
        }
        else {
            week = "każdy"
        }
    }
}