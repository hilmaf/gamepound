import React, { useEffect, useState } from 'react';
import { Button, Form, Table } from 'react-bootstrap';
import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Loading from '../../../component/common/Loading';

const baseURL = process.env.REACT_APP_API_URL;

const StyledCategoryDetailDiv = styled.div`
    & .btnArea {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
    }
`;

const CategoryDetail = () => {

    const navigate = useNavigate();
    const { no } = useParams(); // 글번호 파라미터
    const [loading, setLoading] = useState(false); // 로딩중 표시
    const [dataVo, setDataVo] = useState({}); // 불러온 데이터 vo
    const [formVo, setFormVo] = useState({}); // 보낼 데이터 vo
    const [isChecked, setIsChecked] = useState(false); // 체크 여부를 저장하는 state 변수
    console.log('no : ', no);

    // 데이터
    useEffect(() => {
        setLoading(true);
        fetch(`${baseURL}/category/admin/detail?no=${no}`)
        .then(resp => resp.json())
        .then(data => {
            setDataVo(data);
            console.log(data);
            if(data.delYn === 'Y'){
                setIsChecked(true);
            }
        })
        .catch(() => {
            alert('데이터를 불러오는데 실패했습니다.');
        })
        .finally(() => {
            setLoading(false); // 로딩중 화면 끝
        });
        ;
    }, []);

    // 목록버튼
    const handleListBtn = () => {
        navigate('../category');
    }

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormVo({
            ...formVo,
            [name]: value,
            'no': dataVo.no,
        });
    }

    // 삭제여부
    const handleRadioChange = (e) => {
        const {name} = e.target;
        setFormVo({
            ...formVo,
            [name]: e.target.checked ? 'Y' : 'N',
            'no': dataVo.no,
        });
    }
    console.log(formVo);
    return (
        <StyledCategoryDetailDiv>

            <h2>카테고리 상세</h2>

            <Table bordered responsive>
                <colgroup>
                    <col width='20%'/>
                    <col width='*'/>
                    <col width='20%'/>
                    <col width='*'/>
                </colgroup>
                <tbody>
                    <tr>
                        <td>번호</td>
                        <td colSpan={3}><Form.Control size="sm" type="text" defaultValue={dataVo.no} disabled /></td>
                    </tr>
                    <tr>
                        <td>대분류 번호</td>
                        <td><Form.Control size="sm" type="text" defaultValue={dataVo.mainCategoryNo} disabled /></td>
                        <td>대분류 명</td>
                        <td><Form.Control size="sm" name='mainCategory' type="text" defaultValue={dataVo.mainCategory} onChange={handleInputChange} /></td>
                    </tr>
                    <tr>
                        <td>소분류 번호</td>
                        <td><Form.Control size="sm" type="text" defaultValue={dataVo.subCategoryNo} disabled /></td>
                        <td>소분류 명</td>
                        <td><Form.Control size="sm" name='subCategory' type="text" defaultValue={dataVo.subCategory} onChange={handleInputChange} /></td>
                    </tr>
                    <tr>
                        <td>삭제여부</td>
                        <td colSpan={3}>
                            <Form.Check type="switch" name='delYn' defaultChecked={isChecked} onChange={handleRadioChange} />
                        </td>
                    </tr>
                </tbody>
            </Table>

            <div className="btnArea">
                <Button variant="secondary" onClick={handleListBtn}>목록</Button>
                <Button variant="primary">수정하기</Button>
            </div>

            {loading ? <Loading /> : ''}
        </StyledCategoryDetailDiv>
    );
};

export default CategoryDetail;