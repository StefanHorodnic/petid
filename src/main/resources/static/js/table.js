$(document).ready( function () {
    $('#animalsTable').DataTable( {
        "dom": 'rtip',
        "searching": true,
        "pageLength": 20,
        "pagingType": "numbers",
        language: {
                      "processing": "Procesează...",
                      "lengthMenu": "Afișează _MENU_ înregistrări pe pagină",
                      "zeroRecords": "Nu am găsit nimic - ne pare rău",
                      "info": "Afișate de la _START_ la _END_ din _TOTAL_ înregistrări",
                      "infoEmpty": "Afișate de la 0 la 0 din 0 înregistrări",
                      "infoFiltered": "(filtrate dintr-un total de _MAX_ înregistrări)",
                      "search": "Caută:",
                      "paginate": {
                          "first": "Prima",
                          "previous": "Precedenta",
                          "next": "Următoarea",
                          "last": "Ultima"
                      },
                      "aria": {
                          "sortAscending": "Sortează ascendent",
                          "sortDescending": "Sortează descendent"
                      },
                      "autoFill": {
                          "cancel": "Anulează"
                      },
                      "buttons": {
                          "csv": "CSV",
                          "excel": "Excel",
                          "pageLength": {
                              "-1": "Arată toate rândurile",
                              "_": "Arată %d rânduri"
                          },
                          "pdf": "PDF",
                          "print": "Imprimă",
                          "collection": "Colecție",
                          "colvis": "Vizibilitate coloane",
                          "copy": "Copie",
                          "copyTitle": "Copie în Clipboard"
                      },
                      "searchBuilder": {
                          "add": "Adaugă",
                          "value": "Valoare",
                          "condition": "Condiție",
                          "data": "Data",
                          "logicAnd": "Și",
                          "logicOr": "Sau"
                      },
                      "editor": {
                          "close": "inchide",
                          "create": {
                              "button": "Nou"
                          },
                          "edit": {
                              "button": "Editează",
                              "submit": "Editează"
                          }
                      },
                      "loadingRecords": "Încarcă...",
                      "datetime": {
                          "previous": "Precedentă",
                          "next": "Următoare",
                          "hours": "Ore",
                          "minutes": "Minute",
                          "seconds": "Secunde",
                          "unknown": "Necunoscut",
                          "amPm": [
                              "AM",
                              "PM"
                          ]
                      }
                  }
    });
} );

function searchTable(){
    var table = $('#animalsTable').DataTable();
    var searchText = $('#searchAnimals').val();
    table.search(searchText).draw();
}