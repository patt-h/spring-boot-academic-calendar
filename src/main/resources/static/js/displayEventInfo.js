const closeButton = document.getElementById("closeEvent")
const modal = document.getElementById("modal");

var classType;
var day;
var week;

closeButton.addEventListener("click", () => {
    modal.classList.remove("open");
});

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
