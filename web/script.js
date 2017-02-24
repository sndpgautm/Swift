/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#newTasks').hide();
    $('#addNew').hide();
    /*Navbar functions */
    $('#takeOrder').click(function (event) {
        event.preventDefault();
        $('#newTasks').show();
        $('#addNew').show();
    });
    /*End of Navbar functions */

    //Add button click event
    $('#addNew').click(function () {

        addNewRow();
    });

    //Refresh notes button click event
    $('#refreshNotes').click(function () {
        refreshNotes();
    });

    //Delete button click event
    $('.deleteButton').click(function () {
        deleteRow($(this));
    });

    function addNewRow() {
//        var numRows = $('#newTasks tr').length;
//
//        $('#newTasks').append('<tr><td><input type="text" id="title-' + numRows + '" /></td><td><input type="text" id="orders-' + numRows + '" /></td><td><input type="text" id="status-'+numRows+'" /></td></tr>');
        refreshNotes();
        $('#newTasks').find("input").val("");
        $('#newTasks').hide();
        $('#addNew').hide();
    }

    /**
     * Click event function to start the creation of the task sticky notes
     * Get each of the rows in the task list and create a sticky note for each of them
     */
    function refreshNotes() {


        /* Table functions */
        var tableRows = $('#newTasks');
        console.log(tableRows);
        var title = tableRows.find('input[id^="table"]').val();
        var orders = tableRows.find('input[id^="orders"]').val();
        var status = tableRows.find('input[id^="status"]').val();
        if (title && status && orders) {
            createNotes(title, orders, status);
        }

        console.log(title);

    }
    /*End of table functions */
    /**
     * Creates the sticky notes and gives it a random colour.
     */

    /*Note functions */
    function createNotes(title, orders, status) {
        var header = '<h4>Table No.' + title + '</h4>';
        var desc = '<p>Orders: ' + orders + '</p>';
        var statuses = '<p>Status: ' + status + '</p>';
        var d = new Date(); // for now



        var time = '<p>Time: ' + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds() + '</p>'

        var colours = new Array();
        colours[0] = 'green';
        colours[1] = 'blue';
        colours[2] = 'yellow';
        colours[3] = 'red';
        colours[4] = 'purple';
        colours[5] = 'orange';


        $('.sticky_notes').append('<li class="' + colours[randomFromTo(0, (colours.length - 1))] + '">' + header + desc + statuses + time + '</li>');
    }

    /**
     * Get a random number between 2 numbers
     * 
     * @return Randon Number
     */
    function randomFromTo(from, to) {
        return Math.floor(Math.random() * (to - from + 1) + from);
    }

    /**
     * Deletes the grandparent of the delete button
     */
    function deleteRow(thisButton) {
        $('#newTasks').find("input").val("");
    }

});
/*End of Note functions */
/**
 * Click event function to append a new row to the tasks table
 */


