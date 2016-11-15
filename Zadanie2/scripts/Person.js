function Person(json){
    var self = this;
    self.id = json.id;
    self.name  = json.firstName;
    self.surname = json.lastName;
    self.gender = json.gender;
    self.birthsday = json.birthsday;
    self.email = json.email;
    self.age = json.age;
    
    self.toTableRow = function(){
        return '<tr><td>'
            +self.id
            +'</td><td>'
            +self.name
            +'</td><td>'
            +self.surname
            +'</td><td>'
            +self.gender
            +'</td><td>'
            +self.birthsday
            +'</td><td>'
            +self.email
            +'</td><td>'
            +self.age
            +'</td></tr>'
        
    }
    
}