package com.person.cn.demotestone.uitls;

import com.person.cn.demotestone.bean.NewResult;
import com.person.cn.demotestone.bean.NewResultModel;
import com.person.cn.demotestone.bean.OldResultModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.uitls
 * @updateUser
 * @date 23:062020/10/28
 */
public class MoocUtils {
    public static  final String FAST_JSON="fastJson";
    public static  final String JACKSON ="jackson";

    public  static NewResultModel convert(OldResultModel oldResultModel){
        NewResultModel newResultModel = new NewResultModel();
        NewResult newResult = new NewResult();
        newResult.setNewAge(oldResultModel.getOldResult().getAge());
        newResult.setNewName(oldResultModel.getOldResult().getName());
        newResult.setNewSex(oldResultModel.getOldResult().getSex());
        if(FAST_JSON.equals(oldResultModel.getType())){
            FastJsonSerialize fastJsonSerialize =  MoocSpringContainer.getInstance().getBean(FastJsonSerialize.class);
            newResultModel.setOldResultDesc(fastJsonSerialize.serialize(oldResultModel));
        }else if(JACKSON.equals(oldResultModel.getType())){
            JacksonSerialize jacksonSerialize =  MoocSpringContainer.getInstance().getBean(JacksonSerialize.class);
            newResultModel.setOldResultDesc(jacksonSerialize.serialize(oldResultModel));
        }
        newResultModel.setNewResult(newResult);
        return  newResultModel;
    }
}
