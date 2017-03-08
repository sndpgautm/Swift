/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    

    getFromServer();
    
    /*Navbar functions */
    $('#takeOrder').click(function (event) {
        event.preventDefault();
        $('#newTasks').show();
        $('input[type="button"]').show();
    });
    /*End of Navbar functions */



    /**
     * Click event function to start the creation of the task sticky notes
     * Get each of the rows in the task list and create a sticky note for each of them
     */
    /* Table functions */
    //Add button click event
    $('#addNew').click(function () {

        addNote();
    });

    //Refresh notes button click event
    $('#refreshNotes').click(function () {


        refreshNotes();
    });

    //Delete button click event
    $('.deleteButton').click(function () {


        deleteRow($(this));
    });

    function addNote() {
//        var numRows = $('#newTasks tr').length;
//
//        $('#newTasks').append('<tr><td><input type="text" id="title-' + numRows + '" /></td><td><input type="text" id="orders-' + numRows + '" /></td><td><input type="text" id="status-'+numRows+'" /></td></tr>');
        refreshNotes();
        $('#delafter').nextAll().remove();
        $('#newTasks').find("input").val("");
        
    }

    $('#add-dish-no').click(function () {

        $('#newTasks').append('<tr><td></td><td><input type="text" placeholder="Dish No." inputmode="numeric" name="dishNo[]" ></td></tr>');
    });

    /**
     * Deletes the children of the delete button
     */
    function deleteRow(thisButton) {
        $('#delafter').nextAll().remove();
        $('#newTasks').find("input").val("");

    }
    /*End of table functions */


    /**
     * Creates the sticky notes and gives it a random colour.
     */

    /*Note functions */
    function refreshNotes() {



        var tableRows = $('#newTasks');

        var title = tableRows.find('input[id^="table"]').val();
        var orders = $('input[name="dishNo[]"]').map(function () {
            return parseInt($(this).val());
        }).get();
        var status = tableRows.find('input[id^="status"]').val();


        if (title && status && orders) {
            postInServer(title, orders, status);

        }



    }

    function createNotes(title, orders, status, tPrice) {
        var header = '<h4>Table No.' + title + '</h4>';
        var desc = '<p>Orders: ' + orders[0];

        for (var i = 1; i < orders.length; i++) {
            if (orders[i]) {
                desc += "," + orders[i];
            }

        }


        desc += '</p>';
        var statuses = '<p>Status: ' + status + '</p>';
        var newPrice = '<p>Total Price: ' + tPrice + '</p>';
        var d = new Date(); // for now



        var time = '<p>Time: ' + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds() + '</p>';

        var colours = new Array();
        colours[0] = 'green';
        colours[1] = 'blue';
        colours[2] = 'yellow';
        colours[3] = 'red';
        colours[4] = 'purple';
        colours[5] = 'orange';


        $('.sticky_notes').prepend('<li class="' + colours[randomFromTo(0, (colours.length - 1))] + '">' + header + desc + statuses + time + newPrice + '</li>');
    }

    /**
     * Get a random number between 2 numbers
     * 
     * @return Randon Number
     */
    function randomFromTo(from, to) {
        return Math.floor(Math.random() * (to - from + 1) + from);
    }


    /*End of Note functions */

    /*Server functions */
    function postInServer(title, orders, status) {


        var c = {
            "table_No": parseInt(title),
            "food_Id": orders,
            "status": status

        };
        console.log(c);
        console.log(JSON.stringify(c));
        $.ajax({
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: "json",
            data: JSON.stringify(c),
            url: "http://localhost:8080/Swift/webresources/orders",
            success: function (newOrder) {
                getFromServer();
                





            },
            error: function (xhr, textStatus, errorthrown) {
                $.ajax({
                    type: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    dataType: "json",
                    data: JSON.stringify(c),
                    url: "http://192.168.43.219:8080/Swift/webresources/orders",
                    success: function (newOrder) {
                        getFromServer();





                    }

                });
            }

        });


    }

    function getFromServer() {
        $('#sticks').empty();
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8080/Swift/webresources/orders",
            success: function (orders) {
                for (var i = 0; i < orders.length; i++) {
                    console.log(orders);
                    var tPrice = 0;
                    var itemList = [];
                    for (var j = 0; j < orders[i].items.length; j++) {
                        itemList.push(orders[i].items[j].foodId);
                        console.log(orders[i].items[j].foodId);
                    }
                    createNotes(orders[i].tableNo, itemList, orders[i].status, orders[i].total);



                }

            },
            error: function (xhr, textStatus, errorThrown) {
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    url: "http://192.168.43.219:8080/Swift/webresources/orders",
                    success: function (orders) {
                        for (var i = 0; i < orders.length; i++) {
                            console.log(orders);
                            var tPrice = 0;
                            var itemList = [];
                            for (var j = 0; j < orders[i].items.length; j++) {
                                itemList.push(orders[i].items[j].foodId);
                                console.log(orders[i].items[j].foodId);
                            }
                            createNotes(orders[i].tableNo, itemList, orders[i].status, orders[i].total);



                        }

                    }

                });
            }

        });
    }

    /*End of Server Functions */

});








