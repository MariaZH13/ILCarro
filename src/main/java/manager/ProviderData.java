package manager;

import models.Search;
import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withEmail("marzh@gmail.com")
                .withPassword("Qwert123$")


        });
        list.add(new Object[]{new User()
                .withEmail("marzh@gmail.com")
                .withPassword("Qwert123$")


        });
        list.add(new Object[]{new User()
                .withEmail("marzh@gmail.com")
                .withPassword("Qwert123$")


        });
        return list.iterator();
    }

//    public Iterator<Object[]>searchDTO(){
//        List<Object[]>list = new ArrayList<>();
//        list.add(new Object[]{new Search()
//
//        })
//
//    }
}