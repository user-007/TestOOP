package easterRaces.repositories.interfaces;

import java.util.Collection;

public class Data<T> implements Repository<T>{
  private Collection<T> collection;
    @Override
    public T getByName(String name) {
      for(var x:collection){
          if(String.valueOf(x).equals(name)){
              return x ;
          }
      }
      return null;
    }

    @Override
    public Collection<T> getAll() {
        return collection;
    }

    @Override
    public void add(T model) {
        collection.add(model);
    }

    @Override
    public boolean remove(T model) {
        if(collection.contains(model)){
            collection.remove(model);
        }
        return false;
    }
}
