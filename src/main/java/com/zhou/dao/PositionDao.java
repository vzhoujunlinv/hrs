package com.zhou.dao;

import java.util.List;

import com.zhou.model.Position;

public interface PositionDao {
	/**
     * @param 
     * @return Position
     */
    public void savePos(Position position);
    public List<Position> findAllPos();
    public void updatePos(Position position);
}
