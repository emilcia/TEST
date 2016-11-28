var comparator = new Comparators();

var viewModel = new PeopleTableViewModel({
    pageSize:5,
    count:data.length,
    context:document.getElementById('table')
});

function init(){
    viewModel.next();
}





















