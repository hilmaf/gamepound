import React from 'react';
import { Button, Form, Table } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledCategoryDetailDiv = styled.div`
    & .btnArea {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
    }
`;

const CategoryDetail = () => {

    const navigate = useNavigate();
    
    const handleListBtn = () => {
        navigate('../category');
    }

    return (
        <StyledCategoryDetailDiv>

            <h2>카테고리 상세</h2>

            <Table bordered responsive>
                <colgroup>
                    <col width='20%'/>
                    <col width='*'/>
                </colgroup>
                <tbody>
                    <tr>
                        <td>컬럼명</td>
                        <td><Form.Control size="sm" type="text" /></td>
                    </tr>
                    <tr>
                        <td>컬럼명</td>
                        <td><Form.Control size="sm" type="text" /></td>
                    </tr>
                    <tr>
                        <td>컬럼명</td>
                        <td><Form.Control size="sm" type="text" /></td>
                    </tr>
                    <tr>
                        <td>컬럼명</td>
                        <td><Form.Control size="sm" type="text" /></td>
                    </tr>
                </tbody>
            </Table>

            <div className="btnArea">
                <Button variant="secondary" onClick={handleListBtn}>목록</Button>
                <Button variant="primary">수정하기</Button>
            </div>

        </StyledCategoryDetailDiv>
    );
};

export default CategoryDetail;