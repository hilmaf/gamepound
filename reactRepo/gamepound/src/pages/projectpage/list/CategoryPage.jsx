import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useParams } from 'react-router-dom';
import ProjectListBoxInfo from '../../../component/project/ProjectListBoxInfo';
import Condition from '../../../component/search/Condition';

const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        padding: 20px;
        margin: 0 auto;
        & > div:first-child{
            & > div:first-child{
                font-size: 20px;
                font-weight: 500;
            }
            & > div:last-child{
                & > span{
                    color: var(--red-color);
                }
                margin-top: 20px;
                margin-bottom: 25px;
            }
            
        }
        & > div:last-child{
            display: flex;
            flex-wrap: wrap;
        }
    }
`;

const CategoryPage = () => {

    const {no} = useParams();

    const [categoryVoList, setCategoryVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/list/category?categoryNo=" + no)
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            console.log("categoryPage > fetch");
            setCategoryVoList(data);
            console.log(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, [no]);


    return (
        <StyledAllDiv>
            <div className='inner'>
                <div>
                    <div>{categoryVoList[0]?categoryVoList[0].subCategory:null}</div>
                    <div>
                        <Condition />
                    </div>
                    <div><span>20</span>개의 프로젝트가 있습니다.</div>
                </div>
                <div>
                    {
                        categoryVoList.map((vo)=>{
                            return(<ProjectListBoxInfo project={vo}/>);
                        })

                    }
                </div>
            </div>
        </StyledAllDiv>
    );
};

export default CategoryPage;