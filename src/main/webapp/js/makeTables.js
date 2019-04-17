/**
 * Function for making a table. Is fed header array, tablecontents array and a HTML tag to put it in
 * Styling comes from Bootstrap
 * 
 * @param {type} headerNames    array of header names
 * @param {type} tableContent   array of table contents
 * @param {type} tableID        a HTML tag to put table in
 */
function createTable(headerNames, tableContent, tableID)
{
//    creting fixpoint for table
    var table = document.getElementById(tableID);

    console.log("tableID: " + tableID);
    console.log("table: " + table);
    console.log("HeaderNames: " + headerNames);
    console.log("tableContent: " + tableContent);

//    creating header
    var thead = document.createElement('thead');
    var row = thead.insertRow(0);
    var cell;
    for (var i = 0; i < headerNames.length; i++)
    {
        cell = row.insertCell(i);
        cell.innerHTML = headerNames[i];
    }

    console.log(thead);

//    appending header to table
    table.appendChild(thead);

//    creating body of table
    var tbody = document.createElement('tbody');

//    rows
    for (var i = 0; i < tableContent.length; i++)
    {
        var tr = tbody.insertRow();
//        column
        for (var j = 0; j < tableContent[0].length; j++)
        {
            var indexCellValue = tableContent[i][0];
            var td = tr.insertCell(j);

            td.appendChild(document.createTextNode(tableContent[i][j]));
            console.log(indexCellValue);
        }
    }

//    appending body to tables
    table.appendChild(tbody);

//    fixing styles
//    table
    table.classList.add('table', 'table-hover', 'table-condensed', 'table-striped', 'text-center');

//    head
    thead.classList.add('table');
    thead.style.color = 'white';
    thead.style.background = 'grey';

//    body
    tbody.classList.add('table-bordered');

    console.log(tbody);
}
