import React, { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import { AgGridReact } from 'ag-grid-react'; // React Grid Logic
import "ag-grid-community/styles/ag-grid.css"; // Core CSS
import "ag-grid-community/styles/ag-theme-quartz.css"; // Theme
import styled from 'styled-components';
import { Button, Form, InputGroup } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Pagination from 'react-js-pagination';

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
        creator: ''
    }); // 검색조건
    const {mainCategory, subCategory, status, projectTitle, creator} = conditionVo;
    const [activePage, setActivePage] = useState(1);
    const [pageVo, setPageVo] = useState({
        listCount:0,
        activePage:activePage,
        boardLimit: 10,
        pageLimit: 5
    });
    const [rowData, setRowData] = useState([]);
    const [colDefs, setColDefs] = useState([
        { headerName: "번호", field: "no", autoHeight: true  },
        { headerName: "대분류", field: "mainCategory", autoHeight: true },
        { headerName: "소분류", field: "subCategory", autoHeight: true  },
        { headerName: "프로젝트명", field: "title", autoHeight: true  },
        { headerName: "현황", field: "statusName", autoHeight: true  },
    ]);

    // 숫자페이지 눌렀을때 데이터 불러오기
    const handlePageNumBtn = (pageNumber) => {
        setActivePage(pageNumber);
    }

    // 행 클릭 시 해당 detail페이지로 이동
    const rowClicked = (e) => {
        navigate('../project/detail/${no}')
    }

    // 프로젝트 조회
    useEffect(()=>{
        setLoading(true);
        fetch(`${baseURL}/admin/project?currentPage=${activePage}`)
        .then(resp => resp.json())
        .then(data => {
            console.log(data?.projectList);
            setPageVo({
                ...pageVo,
                listCount: parseInt(data?.cnt)
            })

            setRowData(data?.projectList);
        })
        .catch(()=> {
            alert('데이터를 가져오는 데 실패했습니다.');
        })
        .finally(
            setLoading(false)
        )
        ;
    }, [activePage])

    // 검색조건 불러오기(카테고리)
    useEffect(()=>{
        fetch(`${baseURL}/category/list`)
        .then(resp => resp.json())
        .then(data => {
            console.log(data);
            // const mainCategorySelect = document.querySelector("#mainCategorySelect");
            // for(let i=0; i<data?.length(); i++) {
            //     const newOption = document.createElement("option");
            //     newOption.value = data[i].categoryNo;
            //     newOption.text = data[i].categoryNo;
            //     mainCategorySelect.add(newOption);
            //     console.log(mainCategorySelect.value);
            // }
        })
        .catch()
        .finally()
    }, [])

    // 프로젝트 검색
    const handleSearchBtn = () => {

    }

    return (
        <StyledProjectDiv>
            <h2>프로젝트 관리</h2>
            
            <div className="searchArea">
                <Form>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>대분류</InputGroup.Text>
                        <Form.Select name='mainCategory' id='mainCategory'>
                            <option value='all'>전체</option>
                            <option value='all'>전체</option>
                            <option value='all'>전체</option>
                        </Form.Select>
                        <InputGroup.Text>소분류</InputGroup.Text>
                        <Form.Select name='subCategory' id='subCategory'>
                            <option value='all'>전체</option>
                            <option value='all'>전체</option>
                            <option value='all'>전체</option>
                            <option value='all'>전체</option>
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
                        <Button variant="primary" onClick={handleSearchBtn}>검색</Button>
                    </div>
                </Form>
            </div>

            <div className="totalArea">
                total <strong>{pageVo ? pageVo.listCount : ''}</strong>
            </div>
            <div className="agGridBox ag-theme-quartz">
                <AgGridReact
                    rowData={rowData} 
                    columnDefs={colDefs}
                    animateRows={true} // 행 애니메이션
                    domLayout='autoHeight' // 자동높이
                    onGridReady={(e) => {e.api.sizeColumnsToFit();}} // 칼럼꽉차게
                    onRowClicked={(e) => {rowClicked(e)}} // 행 클릭시 이벤트
                />
            </div>

            {
                pageVo ? 
                <Pagination
                    activePage={activePage} // 현재 보고있는 페이지 
                    itemsCountPerPage={pageVo.boardLimit} // 한페이지에 출력할 아이템수
                    totalItemsCount={pageVo.listCount} // 총 아이템수
                    pageRangeDisplayed={pageVo.pageLimit} // 표시할 페이지수
                    onChange={handlePageNumBtn}> 
                </Pagination>
                :
                ''
            }
            
        </StyledProjectDiv>
    );
};

export default ProjectMain;