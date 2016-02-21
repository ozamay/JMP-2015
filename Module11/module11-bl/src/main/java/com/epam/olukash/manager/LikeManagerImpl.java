package com.epam.olukash.manager;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.LikeDAO;
import com.epam.olukash.dto.Like;

/**
 * @author Oleksii.Lukash
 */
@Component
public class LikeManagerImpl extends AbstractManager<Like, LikeDAO> implements LikeManager
{
}
