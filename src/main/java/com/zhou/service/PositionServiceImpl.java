package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhou.dao.PositionDao;
import com.zhou.model.Position;

@Service
public class PositionServiceImpl implements PositionService{
	@Autowired  
    private PositionDao positionDao;  
	
	public void savePos(Position position)
	{
		positionDao.savePos(position);
	}
	public List<Position> findAllPos()
	{
		return positionDao.findAllPos();
	}
    public void updatePos(Position position)
    {
    	positionDao.updatePos(position);
    }
	public void deletePos(int pId) {
		positionDao.deletePos(pId);
	}
}
