package com.epam.olukash.manager;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.PostDAO;
import com.epam.olukash.dto.Post;

/**
 * @author Oleksii.Lukash
 */
@Component
public class PostMangerImpl extends AbstractManager<Post, PostDAO> implements PostManager
{

}
