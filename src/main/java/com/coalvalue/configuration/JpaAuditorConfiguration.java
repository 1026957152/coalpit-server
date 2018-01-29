package com.coalvalue.configuration;

//import com.coalvalue.domain.entity.User;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Peter Xu on 01/10/2015.
 */
@Component
public class JpaAuditorConfiguration implements AuditorAware<Integer> {

    @Override
    public Integer getCurrentAuditor() {


        System.out.println("----------------current auditor id is 0 ----------------------------------------------------------");
     /*   Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null && auth.isAuthenticated()){
            if(auth.getPrincipal() instanceof  User){
                User user = (User)auth.getPrincipal();
                return user.getId();
            }else {
                return 0;
            }

        }else {
            return 0;
        }*/

        return 0;
    }

}
