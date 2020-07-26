package com.jermine.base.service;

import com.jermine.base.dao.LabelDao;
import com.jermine.base.entity.Label;
import com.jermine.base.exception.BaseBizException;
import com.jermine.base.exception.BaseBizStatusCode;
import com.jermine.common.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        boolean present = labelDao.findById(id).isPresent();
        if (present) {
            return labelDao.findById(id).get();
        } else {
            throw new BaseBizException(BaseBizStatusCode.LABEL_NOT_FOUND);
        }
    }

    public void save(Label label) {
        label.setId(idWorker.nextId().toString());
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void deleteById(String id) {
        try {
            labelDao.deleteById(id);
        } catch (Exception e) {
            BaseBizStatusCode baseBizStatusCode = BaseBizStatusCode.LABEL_DELETE_ERROR;
            throw new BaseBizException(baseBizStatusCode.getCode(), e.getMessage(), baseBizStatusCode.getReturnMessage(), e);
        }
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNoneEmpty(label.getLabelName())){
                    Predicate predicate = builder.like(root.get("labelName").as(String.class), "%" + label.getLabelName() + "%");
                    list.add(predicate);
                }
                return null;
            }
        });
    }
}
