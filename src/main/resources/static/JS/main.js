$(document).ready(function() {

    $('#calendar').fullCalendar({
        customButtons: {
            newVisitButton: {
                text: 'Dodaj wizytę',
                click: function() {
                    window.open("/user/visits/new", "_self");
                }
            },
			manageCustomers: {
                text: 'Klienci',
                click: function() {
                    window.open("/user/customers", "_self");
                }
            }
        },
        header: {
            left: 'prev,next,today, newVisitButton, manageCustomers',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        events: {
            url: '/get-visits'
        },
        eventClick: function(eventObj) {

            var str1="user/visits/";
            window.open(str1.concat(eventObj.idVisit).concat('/edit'), "_self");
        },

    });

    $("#show_today").click(function () {
        $("#calendar").fullCalendar('today');
    });

});