/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Konzul.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.util.AbstractSelectModel;


public class GenericSelectModel<T> extends AbstractSelectModel {

       private String labelField;

       private List<T> list;

       private final PropertyAccess adapter;

       public GenericSelectModel(List<T> list, String labelField, PropertyAccess adapter) {
               this.labelField = labelField;
               this.list = list;
               this.adapter = adapter;
       }

       public List<OptionGroupModel> getOptionGroups() {
               return null;
       }

       public List<OptionModel> getOptions() {
               List<OptionModel> optionModelList = new ArrayList<OptionModel>();
               for (T obj : list) {
                       if (labelField == null) {
                               optionModelList.add(new OptionModelImpl(obj + "", obj));
                       } else {
                               optionModelList.add(new OptionModelImpl(adapter.get(obj, labelField)+"", obj));
                       }
               }
               return optionModelList;
       }
}