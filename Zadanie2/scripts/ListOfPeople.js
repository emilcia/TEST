function ListOfPeople(){
    var people =[];
    var self = this;
    self.addPerson = function(json){
        people.push(new Person(json));
    }
    
    self.toTable = function(){
        var table = '<table>';
        table += generateTableHeader();
        for(var i=0;i<people.length;i++){
            
            table+=people[i].toTableRow(i+1);
            
        }
        table+='</table>'
        return table;
    }
    
    var generateTableHeader= function(){
        return '<tr><th><button>Lp</button></th><th><button onclick="viewModel.sort(comparator.byId)">Id</button></th><th><button onclick="viewModel.sort(comparator.byName)">Name</button></th><th><button onclick="viewModel.sort(comparator.bySurname)">Surname</button></th> <th><button onclick="viewModel.sort(comparator.byGender)">Gender</button></th> <th><button onclick="viewModel.sort(comparator.byBirthsday)">Birthsday</button></th> <th><button onclick="viewModel.sort(comparator.byEmail)">Email</button></th> <th><button onclick="viewModel.sort(comparator.byAge)">Age</button></th> </tr>'
    }
    
    self.clear = function(){
        people = [];
    }
}