import React, { useCallback, useEffect, useMemo, useState } from 'react';
import { AgGridReact } from 'ag-grid-react'; // React Grid Logic
import "ag-grid-community/styles/ag-grid.css"; // Core CSS
import "ag-grid-community/styles/ag-theme-quartz.css"; // Theme
import styled from 'styled-components';
import { Button, Form, InputGroup, Pagination } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const baseURL = process.env.REACT_APP_API_URL;

const StyledCategoryDiv = styled.div`
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
    .ag-header-cell-center {
        & .ag-header-cell-label {
            justify-content: center;
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

const CategoryMain = () => {

    const navigate = useNavigate();
    const [dataVo, setDataVo] = useState([]);

    // 카테고리 조회
    useEffect(() => {
        fetch(`${baseURL}/category/list`)
        .then(resp => resp.json())
        .then(data => {
            setDataVo(data);
        })
        .catch(() => {
            alert('데이터를 가져오는데 실패했습니다.');
        })
        ;
    }, []);
    console.log(dataVo);

    // Row Data: The data to be displayed.
    const [rowData, setRowData] = useState([]); // 데이터

    // 컬럼 데이터 채우기
    useEffect(() => {
        const allSubCategories = dataVo.map(item => item.subCategoryList).flat();
        setRowData(allSubCategories);
    }, [dataVo]);

    // Column Definitions: Defines & controls grid columns.
    const [colDefs, setColDefs] = useState([
        { headerName: "번호", field: "no", autoHeight: true, width: 50, headerClass: 'ag-header-cell-center', cellStyle: {textAlign: 'center'}},
        { headerName: "대분류명", field: "mainCategory" , autoHeight: true, headerClass: 'ag-header-cell-center'},
        { headerName: "소분류명", field: "subCategory", autoHeight: true, headerClass: 'ag-header-cell-center' },
    ]);

    // useEffect(() => {
    //     const title = dataVo.subCategoryList.map(vo => {
    //         vo.
    //     });
    //     setColDefs();
    // }, []);

    let active = 0; // 활성화
    const handlePageNum = (e) => {
        console.log(e.target.innerHTML);
        active = e.target.innerHTML;
    }

    const pageSize = 10;

    // 페이지네이션
    let items = [];
    for (let number = 1; number <= 10; number++) {
        items.push(
            <Pagination.Item key={number} active={number === active} onClick={handlePageNum}>
                {number}
            </Pagination.Item>,
        );
    }
    // const onFirstDataRendered = useCallback((params) => {
    //     params.api.paginationGoToPage(4);
    // }, []);

    const rowClicked = (e) => {
        navigate('../category/detail')
    }

    return (
        <StyledCategoryDiv>
            <h2>카테고리 관리</h2>
            
            <div className="searchArea">
                <Form>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>검색조건</InputGroup.Text>
                        <Form.Control placeholder="Username" />
                    </InputGroup>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>검색조건</InputGroup.Text>
                        <Form.Control placeholder="Username" />
                    </InputGroup>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>검색조건</InputGroup.Text>
                        <Form.Control placeholder="Username" />
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
            
        </StyledCategoryDiv>
    );
};

export default CategoryMain;