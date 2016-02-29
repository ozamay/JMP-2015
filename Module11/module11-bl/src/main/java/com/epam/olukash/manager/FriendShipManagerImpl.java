package com.epam.olukash.manager;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.FriendshipDAO;
import com.epam.olukash.dto.FriendShip;

/**
 * @author Oleksii.Lukash
 */
@Component
public class FriendShipManagerImpl extends AbstractManager<FriendShip, FriendshipDAO> implements FriendShipManager
{
}
