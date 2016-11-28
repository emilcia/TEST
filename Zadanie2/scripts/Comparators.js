function Comparators(){
    var self = this;
    self.zmienna = false;
    self.byId = function(person1, person2){
        if(!self.zmienna)
            {
                return person1.id - person2.id;
            }
        else
                return person2.id - person1.id;
    }
    self.byName = function(person1, person2){
        if (!self.zmienna)
            {
                return person1.firstName.localeCompare(person2.firstName)
            }
        else
                return person2.firstName.localeCompare(person1.firstName)
            
    }
    
    self.bySurname = function(person1, person2){
        if(!self.zmienna)
            {
                return person1.lastName.localeCompare(person2.lastName);
            }
        else
                return person2.lastName.localeCompare(person1.lastName);
    }
    
    self.byAge = function(person1, person2){
        if(!self.zmienna)
            {
                return person1.age - person2.age;
            }
        else
                return person2.age - person1.age;
    }
    self.byBirthsday = function(person1, person2){
        if(!self.zmienna)
            {
                return person1.birthsday.localeCompare(person2.birthsday);
            }
        else
                return person2.birthsday.localeCompare(person1.birthsday);
    }
    self.byGender = function(person1, person2){
        if(!self.zmienna)
            {
                return person1.gender.localeCompare(person2.gender);
            }
        else
                return person2.gender.localeCompare(person1.gender);
    }
    self.byEmail = function(person1, person2){
        if(!self.zmienna)
            {
                return person1.email.localeCompare(person2.email);
            }
        else    
                return person2.email.localeCompare(person1.email);
    }
        self.change = function(){
        if(!self.zmienna)
                {
                    self.zmienna = true;
                }
            else
                self.zmienna = false;
        }
    
}