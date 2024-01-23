import React, { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import { AgGridReact } from 'ag-grid-react'; // React Grid Logic
import "ag-grid-community/styles/ag-grid.css"; // Core CSS
import "ag-grid-community/styles/ag-theme-quartz.css"; // Theme
import styled from 'styled-components';
import { Button, Form, InputGroup, Pagination } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const baseURL = process.env.REACT_APP_API_URL;

const StyledProjectDiv = styled.div`
    // search
    & .searchArea {
        padding: 30px;
        background-color: #fff;
        border-radius: 5px;
        margin-bottom: 30px;
        box-shadow: 0 0 11px 0 rgba(0, 0, 0, .05);
        & .btnArea {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
        }
    }
    & .input-group {
        & .input-group-text {
            font-size: 14px;
            color: #999;
        }
        & .form-control {
            font-size: 14px;
            &::placeholder {
                color: #ddd;
            }
        }
    }

    & .agGridBox {
        /* height: 500px; */
        height: 100%;
        width: 100%;
    }

    /* 각 행(tr.ag-row)의 높이를 자동으로 조절 */
    .ag-theme-quartz .ag-cell {
        white-space: normal !important; /* 텍스트 래핑 활성화 */
    }
    .pagination {
        justify-content: center;
        margin-top: 30px;
        & li {
            & .page-link {
                display: flex;
                align-items: center;
                justify-content: center;
                min-width: 31px;
                color: #333;
            }
            &.active .page-link {
                color: #fff;
            }
        }
    }

    & .totalArea {
        font-size: 14px;
        padding: 10px;
        letter-spacing: 1px;
        & strong {
            font-weight: 500;
        }
    }
`;

const ProjectMain = () => {

    const navigate = useNavigate();
    const [loading, setLoading] = useState(false); // 로딩중
    const [conditionVo, setConditionVo] = useState({
        mainCategory: '',
        subCategory: '',
        status: '',
        projectTitle: '',
        creator: '',
        currentPage: ''
    }); // 검색조건
    const {mainCategory, subCategory, status, projectTitle, creator, currentPage} = conditionVo;
    const [pageVo, setPageVo] = useState();
    const [activePage, setActivePage] = useState(1);
    const [dataVo, setDataVo] = useState({});
    const [rowData, setRowData] = useState([]);
    const [colDefs, setColDefs] = useState([
        { field: "번호", autoHeight: true  },
        { field: "대분류" , autoHeight: true },
        { field: "소분류", autoHeight: true  },
        { field: "프로젝트명", autoHeight: true  },
        { field: "현황", autoHeight: true  },
    ]);
    const pageSize = 10;

    // 페이지네이션
    let active = 1; // 활성화
    let items = [];
    for (let number = 1; number <= 10; number++) {
        items.push(
            <Pagination.Item key={number} active={number === active}>
            {number}
            </Pagination.Item>,
        );
    }

    const rowClicked = (e) => {
        navigate('../project/detail')
    }

    // 프로젝트 조회
    useEffect(()=>{
        setLoading(true);
        fetch(`${baseURL}/admin/project?currentPage=${currentPage}`)
        .then(resp => resp.json())
        .then(data => {
            setDataVo(data);
        })
        .catch(()=> {
            alert('데이터를 가져오는 데 실패했습니다.');
        })
        .finally(
            setLoading(false)
        )
        ;
    }, [])

    return (
        <StyledProjectDiv>
            <h2>프로젝트 관리</h2>
            
            <div className="searchArea">
                <Form>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>대분류</InputGroup.Text>
                        <Form.Select name='mainCategory'>
                            <option value='all'>전체</option>
                            <option value='video'>비디오게임</option>
                            <option value='mobile'>모바일게임</option>
                        </Form.Select>
                        <InputGroup.Text>소분류</InputGroup.Text>
                        <Form.Select name='subCategory'>
                            <option value='all'>전체</option>
                            <option>전체</option>
                            <option>전체</option>
                            <option>전체</option>
                            <option>전체</option>
                            <option>전체</option>
                        </Form.Select>
                        <InputGroup.Text>현황</InputGroup.Text>
                        <Form.Select name='status'>
                            <option>전체</option>
                            <option>심사중</option>
                            <option>승인됨</option>
                            <option>반려됨</option>
                            <option>진행중</option>
                            <option>펀딩종료(성공)</option>
                            <option>펀딩종료(실패)</option>
                        </Form.Select>
                    </InputGroup>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>프로젝트명</InputGroup.Text>
                        <Form.Control placeholder="프로젝트명" />
                    </InputGroup>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>창작자명</InputGroup.Text>
                        <Form.Control placeholder="창작자명" />
                    </InputGroup>

                    <div className="btnArea">
                        <Button variant="secondary">초기화</Button>
                        <Button variant="primary">검색</Button>
                    </div>
                </Form>
            </div>

            <div className="totalArea">
                total <strong>30</strong>
            </div>
            <div className="agGridBox ag-theme-quartz">
                <AgGridReact
                    rowData={rowData} 
                    columnDefs={colDefs}
                    animateRows={true} // 행 애니메이션
                    domLayout='autoHeight' // 자동높이
                    onGridReady={(e) => {e.api.sizeColumnsToFit();}} // 칼럼꽉차게
                    pagination={true} // 페이징처리
                    paginationPageSize={pageSize} // 한 페이지당 보여줄 열의 개수
                    suppressPaginationPanel={true} // ag-grid에서 제공하는 페이징 컨트롤패널 안씀
                    onRowClicked={(e) => {rowClicked(e)}} // 행 클릭시 이벤트
                />
            </div>

            <Pagination size="sm">
                <Pagination.First />
                <Pagination.Prev />
                
                {items}

                <Pagination.Next />
                <Pagination.Last />
            </Pagination>
            
        </StyledProjectDiv>
    );
};

export default ProjectMain;