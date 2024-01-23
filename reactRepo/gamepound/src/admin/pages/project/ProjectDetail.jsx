import React, { useEffect, useState } from 'react';
import { Button, Form, Table } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';
import styled from 'styled-components';
import Loading from '../../../component/common/Loading';

const baseURL = process.env.REACT_APP_API_URL;

const StyledProjectDetailDiv = styled.div`
    & .btnArea {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
    }
`;

const ProjectDetail = () => {
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
        fetch(`${baseURL}/admin/project/detail?no=${no}`)
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
        <StyledProjectDetailDiv>

            <h2>프로젝트 상세</h2>

            <Table bordered responsive>
                <colgroup>
                    <col width='10%'/>
                    <col width='10%'/>
                    <col width='10%'/>
                    <col width='10%'/>
                    <col width='10%'/>
                    <col width='10%'/>
                    <col width='10%'/>
                    <col width='10%'/>
                </colgroup>
                <tbody>
                    <tr>
                        <td>프로젝트명</td>
                        <td colSpan={7}><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                    <tr>
                        <td>프로젝트 번호</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>대분류 명</td>
                        <td><Form.Control size="sm" name='mainCategory' type="text" defaultValue={dataVo.mainCategory} disabled /></td>
                        <td>소분류 명</td>
                        <td><Form.Control size="sm" name='subCategory' type="text" defaultValue={dataVo.subCategory} onChange={handleInputChange} disabled/></td>
                        <td>창작자 명</td>
                        <td><Form.Control size="sm" type="text" name='member' disabled/></td>
                    </tr>
                    <tr>
                        <td>목표 금액</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>모인 금액</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>달성률</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td colSpan={2}></td>
                    </tr>
                    <tr>
                        <td>URL</td>
                        <td colSpan={7}><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                    <tr>
                        <td colSpan={8}></td>
                    </tr>
                    <tr>
                        <td colSpan={8}><strong>현황 정보</strong></td>
                    </tr>
                    <tr>
                        <td>현황</td>
                        <td><Form.Select size="sm" type="select">
                            <option value="checking">심사중</option>
                            <option value="approved">승인됨</option>
                            <option value="rejected">반려됨</option>
                            <option value="process">진행중</option>
                            <option value="success">펀딩종료(성공)</option>
                            <option value="fail">펀딩종료(실패)</option>
                            </Form.Select></td>
                        <td colSpan={2}></td>
                        <td>등록일</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>승인일</td>
                        <td><Form.Control size="sm" type="text" name='okDate' disabled/></td>
                    </tr>
                    <tr>
                        <td colSpan={4}></td>
                        <td>펀딩 시작일</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>펀딩 종료일</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                    <tr>
                        <td colSpan={8}></td>
                    </tr>
                    <tr>
                        <td colSpan={8}><strong>선물 정보</strong></td>
                    </tr>
                    <tr>
                        <td colSpan={8}><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                    <tr>
                        <td colSpan={8}><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                    <tr>
                        <td colSpan={8}><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                    <tr>
                        <td colSpan={8}></td>
                    </tr>
                    <tr>
                        <td colSpan={8}><strong>정산 정보</strong></td>
                    </tr>
                    <tr>
                        <td>거래은행</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>예금주 명</td>
                        <td><Form.Control size="sm" type="text" disabled /></td>
                        <td>계좌번호</td>
                        <td colSpan={3}><Form.Control size="sm" type="text" disabled /></td>
                    </tr>
                </tbody>
            </Table>

            <div className="btnArea">
                <Button variant="secondary" onClick={handleListBtn}>목록</Button>
                <Button variant="primary">수정하기</Button>
            </div>

            {loading ? <Loading /> : ''}
        </StyledProjectDetailDiv>
    );
};

export default ProjectDetail;