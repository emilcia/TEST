function PeopleTableViewModel(config){
    var self = this;
    self.people = new ListOfPeople();
    self.currentPage = 0;
    self.pageSize = config.pageSize;
    self.context = config.context;
    
    self.setSize = function(size){
        self.people.clear();
        self.pageSize = size;
            var begin = (self.currentPage)*self.pageSize;
            var end = (self.currentPage+1)*self.pageSize;
            getData(begin,end);
            self.context.innerHTML=self.people.toTable();
        
    }
    
            var getData = function(begin, end){
    if(end>data.length){
        end=data.length
    }
    if(begin<0){
        begin=0;
    }
    for(var i = begin; i<end; i+=1){
        self.people.addPerson(data[i]);
    }
}
    
        self.next = function(){
            self.people.clear();
            var begin = (self.currentPage)*self.pageSize;
            var end = (self.currentPage+1)*self.pageSize;
            getData(begin,end);
        if(self.currentPage+1<(1000/self.pageSize))
            {
            self.currentPage++;
            }
            self.context.innerHTML=self.people.toTable();
            
        }
        self.prev = function(){
            self.people.clear();
            if(self.currentPage-1>=0){
                self.currentPage--;
            }
            var begin = (self.currentPage)*self.pageSize;
            var end = (self.currentPage+1)*self.pageSize;
            getData(begin,end);
            self.context.innerHTML=self.people.toTable();
        }
        
        
        self.sort = function(comparer){
            data.sort(comparer);
            comparator.change();
            self.currentPage=0;
            self.next();

        }
    
}
