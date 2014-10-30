/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.dao.account;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.account.PendingInvitation;

/**
 *
 * @author Łukasz Gadomski
 */
public interface PendingInvitationDao extends CrudDao<PendingInvitation, Long> {

    PendingInvitation findByToken(String token);

    PendingInvitation findByEmail(String email);

}
