/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.project.core.dao.account;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.domain.account.PendingInvitation;

/**
 *
 * @author Łukasz Gadomski
 */
public interface PendingInvitationDao extends CrudDao<PendingInvitation, Long> {

    PendingInvitation findByToken(String token);

    PendingInvitation findByEmail(String email);

}
