/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

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
        var numRows = $('#newTasks tr').length;

        $('#newTasks').append('<tr><td><input type="text" id="title-' + numRows + '" /></td><td><input type="text" id="orders-' + numRows + '" /></td></tr>');

    }

    /**
     * Click event function to start the creation of the task sticky notes
     * Get each of the rows in the task list and create a sticky note for each of them
     */
    function refreshNotes() {

        var tableRows = $('#newTasks tr');

        $('.sticky_notes li').remove();

        $.each(tableRows, function (i) {
            var title = $(this).find('input[id^="title"]').val();
            var orders = $(this).find('input[id^="orders"]').val();
            var status = $(this).find('input[id^="status"]').val();
            console.log("hello");
            if (title != undefined && orders != undefined && status != undefined) {
                createNotes(title, orders, status);
            }
        });
    }

    /**
     * Creates the sticky notes and gives it a random colour.
     */
    function createNotes(title, orders, status) {
        var header = '<h4>Table No.' + title + '</h4>';
        var desc = '<p>Orders: ' + orders + '</p>';
        var statuses = '<p>Status: ' + status + '</p>';
        var d = new Date(); // for now
         
        
       
        var time = '<p>Time: ' +d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+'</p>'

        var colours = new Array();
        colours[0] = 'green';
        colours[1] = 'blue';
        colours[2] = 'yellow';
        colours[3] = 'red';
        colours[4] = 'purple';
        colours[5] = 'orange';


        $('.sticky_notes').append('<li class="' + colours[randomFromTo(0, (colours.length - 1))] + '">' + header + desc + statuses + time+'</li>');
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
        thisButton.parent().parent().remove();
    }

});

/**
 * Click event function to append a new row to the tasks table
 */

